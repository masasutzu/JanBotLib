package janbotlib;

import java.util.Observable;



/**
 * 麻雀ゲーム管理
 */
class JanGameMaster extends Observable implements GameMaster {
    
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
     * 監視者に状態を通知 (強制)
     */
    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }
    
    /**
     * 開始
     */
    public void onStart() {
        notifyObservers();
    }
    
    
    
    /**
     * 自分自身のインスタンス
     */
    private static final JanGameMaster INSTANCE = new JanGameMaster();
    
}
