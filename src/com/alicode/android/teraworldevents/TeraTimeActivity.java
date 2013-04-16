/***
  Copyright (c) 2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  From _The Busy Coder's Guide to Android Development_
    http://commonsware.com/Android
 */

package com.alicode.android.teraworldevents;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class TeraTimeActivity extends SherlockFragmentActivity implements
		TabListener {
	private static final String KEY_MODELS = "models";
	private static final String KEY_POSITION = "position";
	private CharSequence[] models = new CharSequence[10];
	private Rect t;
	private View target;

	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);

		if (state != null) {
			models = state.getCharSequenceArray(KEY_MODELS);
		}

		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		for (int i = 0; i <= 4; i++) {
			if (i == 0)
				bar.addTab(bar.newTab().setText("US Nexus")
						.setTabListener(this).setTag(i));
			if (i == 1)
				bar.addTab(bar.newTab().setText("EU Nexus")
						.setTabListener(this).setTag(i));
			if (i == 2)
				bar.addTab(bar.newTab().setText("Leaderboard")
						.setTabListener(this).setTag(i));
			if (i == 3)
				bar.addTab(bar.newTab().setText("Dailies").setTabListener(this)
						.setTag(i));
			if (i == 4)
				bar.addTab(bar.newTab().setText("Dungeons")
						.setTabListener(this).setTag(i));
		}

		if (state != null) {
			bar.setSelectedNavigationItem(state.getInt(KEY_POSITION));
		}

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.main, menu);
		return (super.onCreateOptionsMenu(menu));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			return (true);
		case R.id.about:
			startActivity(new Intent(this, AboutActivity.class));
			return (true);
		case R.id.help:
			startActivity(new Intent(this, HelpActivity.class));
			return (true);
		}
		return (super.onOptionsItemSelected(item));
	}

	@Override
	public void onSaveInstanceState(Bundle state) {
		state.putCharSequenceArray(KEY_MODELS, models);
		state.putInt(KEY_POSITION, getSupportActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		int i = ((Integer) tab.getTag()).intValue();

		if (i == 0)
			ft.replace(android.R.id.content,
					UsNexusFragment.newInstance(i, models[i]));
		if (i == 1)
			ft.replace(android.R.id.content,
					EuNexusFragment.newInstance(i, models[i]));
		if (i == 2)
			ft.replace(android.R.id.content,
					BgArenaFragment.newInstance(i, models[i]));
		if (i == 3)
			ft.replace(android.R.id.content,
					EliteDailiesFragment.newInstance(i, models[i]));
		if (i == 4)
			ft.replace(android.R.id.content,
					DungeonCooldownFragment.newInstance(i, models[i]));
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		int i = ((Integer) tab.getTag()).intValue();
		UsNexusFragment usN = null;
		EuNexusFragment euN = null;
		BgArenaFragment bgA = null;
		EliteDailiesFragment eDay = null;
		DungeonCooldownFragment sUp = null;

		if (i == 0)
			usN = (UsNexusFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);

		if (i == 1)
			euN = (EuNexusFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);

		if (i == 2)
			bgA = (BgArenaFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);

		if (i == 3)
			eDay = (EliteDailiesFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);

		if (i == 4)
			sUp = (DungeonCooldownFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// unused
	}
}