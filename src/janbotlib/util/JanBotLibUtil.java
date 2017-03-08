package janbotlib.util;

import janbotlib.GameAnnouncer;
import janbotlib.GameMaster;

public final class JanBotLibUtil {
    
    /**
     * コンストラクタ
     */
    public JanBotLibUtil(GameAnnouncer announcer) {
        GameMaster.getInstance().addObserver(announcer);
    }
    
    
    
    /**
     * 開始
     */
    public void start() {
        GameMaster.getInstance().onStart();
    }

}
