package janbotlib;

import java.util.List;
import java.util.Map;
import java.util.Observer;

import janbotlib.exception.JanException;
import wiz.project.jan.JanPai;
import wiz.project.jan.Player;
import wiz.project.jan.Wind;



/**
 * 中国麻雀コントローラ
 */
class ChmJanController implements JanController {
    
    /**
     * コンストラクタ
     */
    public ChmJanController() {
    }
    
    /**
     * コンストラクタ
     * 
     * @param observer 監視者。
     */
    public ChmJanController(final Observer observer) {
    }
    
    /**
     * 開始
     */
    public void start(final List<JanPai> deck, final Map<Wind, Player> playerTable) throws JanException {
        if (deck == null) {
            throw new NullPointerException("Deck is null.");
        }
        if (playerTable == null) {
            throw new NullPointerException("Player table is null.");
        }
        if (deck.size() != (JanPai.values().length * 4)) {
            throw new IllegalArgumentException("Invalid deck size - " + deck.size());
        }
        if (playerTable.size() != 4) {
            throw new IllegalArgumentException("Invalid player table size - " + playerTable.size());
        }
        if (_onGame) {
            throw new JanException("Game is already started.");
        }
        
        synchronized (_GAME_INFO_LOCK) {
        }
    }
    
    
    
    /**
     * ロックオブジェクト
     */
    private final Object _GAME_INFO_LOCK = new Object();
    
    
    
    /**
     * ゲーム中か
     */
    private volatile boolean _onGame = false;
    
}
