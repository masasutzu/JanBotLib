package janbotlib;

import java.util.Observable;

public class GameMaster extends Observable {

    /**
     * コンストラクタを自分自身に限定許可
     */
    private GameMaster() {
    }



    /**
     * インスタンスを取得
     *
     * @return インスタンス。
     */
    public static GameMaster getInstance() {
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
    private static final GameMaster INSTANCE = new GameMaster();

}
