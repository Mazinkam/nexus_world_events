package com.alicode.android.teraworldevents;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends Activity {
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
		String page = "<html>"
				+ "<body bgcolor='#6E6E6E' font color='white'><h3>About:</h3>"
				+ "This app features world events of the online MMORPG TERA ONLINE. It will show you the world events based on you own timezome. "
				+ "<br>"
				+ "Here is a link to the <a href= 'http://tera.enmasse.com/'>NA</a> and <a href= 'http://tera-europe.com/en/home.html'>EU</a> versions respectively."
				+ "<br><br><br>"
				+ "<h3>Contact:</h3>"
				+ "If you have any suggestions,bug reports, content updates, etc. Feel free to email me"
				+ "<br>" + " ali 'DOT' abdulkarim90 'AT' gmail 'DOT' com" + "."
				+ "</body></html>";
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

