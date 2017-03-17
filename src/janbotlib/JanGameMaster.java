package janbotlib;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import janbotlib.exception.JanException;
import wiz.io.serializer.Serializer;
import wiz.project.jan.JanPai;
import wiz.project.jan.Wind;
import wiz.project.jan.util.JanPaiUtil;

/**
 * 麻雀ゲーム管理
 */
class JanGameMaster implements GameMaster {
    
    /**
     * コンストラクタを自分自身に限定許可
     */
    private JanGameMaster() {
    }
    
    
    
    /**
     * インスタンスを取得
     *
     * @return インスタンス。
     */
    public static JanGameMaster getInstance() {
        return INSTANCE;
    }
    
    /**
     * 初期化
     */
    public void initialize(GameAnnouncer announcer) {
        _controller = new ChmJanController(announcer);
    }
    
    /**
     * 開始
     */
    public void onStart() {
        final String playerName = "kiefer";
        // 牌山生成と席決め
        final List<JanPai> deck = createDeck();
        final Map<Wind, Player> playerTable = createPlayerTable(Arrays.asList(playerName));
        
        // 保存 (リプレイ用)
        try {
            Serializer.writeOverwrite(deck, DECK_SAVE_PATH);
            Serializer.writeOverwrite(playerTable, PLAYER_TABLE_SAVE_PATH);
            _controller.start(deck, playerTable);
        } catch (IOException e) {
        } catch (JanException e) {
        }
    }
    
    
    
    /**
     * 牌山を生成
     * 
     * @return 牌山。
     */
    private List<JanPai> createDeck() {
        final List<JanPai> deck = JanPaiUtil.createAllJanPaiList();
        Collections.shuffle(deck, new SecureRandom());
        return deck;
    }
    
    /**
     * プレイヤーテーブルを生成
     * 
     * @param playerNameList 参加プレイヤー名のリスト。
     * @return プレイヤーテーブル。
     */
    private Map<Wind, Player> createPlayerTable(final List<String> playerNameList) {
        // 風をシャッフル
        final List<Wind> windList = new ArrayList<>(Arrays.asList(Wind.values()));
        Collections.shuffle(windList, new SecureRandom());
        
        // プレイヤーを格納
        final Map<Wind, Player> playerTable = new TreeMap<>();
        for (final String playerName : playerNameList) {
            playerTable.put(windList.remove(0), new Player(playerName, PlayerType.HUMAN));
        }
        
        // 4人になるまでNPCで埋める
        final int limitCOM = 4 - playerNameList.size();
        for (int i = 0; i < limitCOM; i++) {
            playerTable.put(windList.remove(0), NPC_LIST.get(i));
        }
        return playerTable;
    }
    
    
    
    /**
     * 自分自身のインスタンス
     */
    private static final JanGameMaster INSTANCE = new JanGameMaster();
    
    
    
    /**
     * ゲームコントローラ
     */
    private JanController _controller = new ChmJanController();
    
    
    
    /**
     * 保存パス
     */
    private static final String DECK_SAVE_PATH         = "./deck.bin";
    private static final String PLAYER_TABLE_SAVE_PATH = "./player_table.bin";
    
    /**
     * NPCリスト
     */
    private static final List<Player> NPC_LIST =
        Collections.unmodifiableList(Arrays.asList(new Player("COM_01", PlayerType.COM),
                                                   new Player("COM_02", PlayerType.COM),
                                                   new Player("COM_03", PlayerType.COM)));
    
}
