package janbotlib;

/**
 * ライブラリ本体
 */
public final class JanBotLib {
    
    /**
     * コンストラクタ利用禁止
     */
    private JanBotLib() {}
    
    
    
    /**
     * 初期化処理
     */
    public static void initialize(GameAnnouncer announcer) {
        JanGameMaster.getInstance().initialize(announcer);
    }
    
    /**
     * 開始
     */
    public static void start() {
        JanGameMaster.getInstance().onStart();
    }

}
