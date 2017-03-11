package com.idc.grepgui;

import com.idc.trace.Debug;

public class AppThread extends Thread {
	private GrepdirGui m_app;
	private Grepdir m_grepdir;
	private boolean m_bPleaseSuspendThisThread = true;
	private boolean m_bStop = false;
	
	public AppThread (GrepdirGui app, Grepdir grepdir) {
		Debug.println(">>> AppThread::constructor");
		m_app = app;
		m_grepdir = grepdir;
		m_bPleaseSuspendThisThread = true;
		Debug.println("<<< AppThread::constructor");		
	}
	public void setSuspend() {m_bPleaseSuspendThisThread = true;}
	public boolean getStopStatus() {return m_bStop;}
	private synchronized void setResume() {
		m_bPleaseSuspendThisThread = false;
		notify();
	}
	public void setStart () {
		m_bStop = false;
		setResume();
	}
	public void setStop() {
		setResume();
		m_bStop = true;
	}
	public void run() {
		Debug.println(">>> AppThread::run");
		while (! m_app.isAppOver()) {
			try {
				synchronized (this) {
					while (m_bPleaseSuspendThisThread) {
						Debug.println("suspending thread");
						wait();
					}
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			Debug.println("Searching directories :"+m_app.getDirField()+":");				
			m_grepdir.doGrepdir(m_app.getDirField(), m_app.getStringField(), 
						m_app.getTypeField());
			Debug.println("Search is complete");					
			m_app.setStopped();
			setSuspend();
		}
		Debug.println("<<< AppThread::run");
	}
}

