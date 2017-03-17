package janbotlib;

import java.util.List;
import java.util.Map;

import janbotlib.exception.JanException;
import wiz.project.jan.JanPai;
import wiz.project.jan.Wind;



/**
 * 麻雀コントローラ
 */
interface JanController {
    
    /**
     * 開始
     * 
     * @param deck 牌山。
     * @param playerTable プレイヤーテーブル。
     * @throws JanException 例外イベント。
     */
    public void start(final List<JanPai> deck, final Map<Wind, Player> playerTable) throws JanException;
    
}

