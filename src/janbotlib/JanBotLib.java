package janbotlib;

import janbotlib.GameAnnouncer;
import janbotlib.GameMaster;

public final class JanBotLib {
    
    /**
     * コンストラクタ
     */
    public JanBotLib(GameAnnouncer announcer) {
        GameMaster.getInstance().addObserver(announcer);
    }
    
    
    
    /**
     * 開始
     */
    public void start() {
        GameMaster.getInstance().onStart();
    }

}
