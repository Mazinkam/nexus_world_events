package com.alicode.android.teraworldevents;

import java.util.Date;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HelpActivity extends Activity {
	WebView browser;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.about);
		browser = (WebView) findViewById(R.id.webkit);

		browser.setWebViewClient(new Callback());
		loadTime();
	}

	void loadTime() {
		String page ="<html>" +
				"<body bgcolor='#6E6E6E' font color='white'>" +
				"<h1>Terms used:</h1>" +
				"<ul>" +
				"<li>NA - North America</li>" +
				"<li>EU - Europe</li>" +
				"<li>Leaderboard - BG/3v3 ranking</li>" +
				"<li>NA Nexus - North American Nexus</li>" +
				"<li>EU Nexus- European Nexus</li>" +
				"<li>Leaderboard - BG/3v3 ranking</li>" +
				"<li>BG - Fraywind Canyon</li>" +
				"<li>3v3 - Champions' Skyring</li>" +
				"<li>Elite - Elite Status ingame</li>" +
				"<li>Club - EU version of Elite</li>" +
				"<li>Dailies - Daily quests</li>" +
				"<li>MCHM - Manaya's Core( Hard Mode)</li>" +
				"<li>SJG - Serjukas Gallery</li>" +
				"<li>CoF - Crucible of Flame</li>" +
				"<li>Daily dungeons - Limited enterance</li>" +
				"<dd>-MCHM</dd>" +
				"<dd>-SJG</dd>" +
				"<dd>-CoF</dd>" +
				"</li>"+
			
				"</ul> "+
				"</body></html>";
		browser.loadData(page, "text/html", "UTF-8");
	}

	private class Callback extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			loadTime();
			return (true);
		}
	}
}