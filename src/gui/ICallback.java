package gui;

import java.util.concurrent.Callable;

public interface ICallback<T> {

	T callback(Callable<T> callback) throws Exception;

}
