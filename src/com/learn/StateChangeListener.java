package com.learn;

import java.lang.Thread.State;
@FunctionalInterface
public interface StateChangeListener {
	public void onStateChange(State oldState, State newState);
}
