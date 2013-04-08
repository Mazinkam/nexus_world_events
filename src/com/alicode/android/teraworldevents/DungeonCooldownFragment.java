package com.alicode.android.teraworldevents;

import java.util.ArrayList;
import java.util.HashMap;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class DungeonCooldownFragment extends SherlockFragment implements
		TextWatcher, OnItemClickListener {
	private static final String KEY_POSITION = "position";

	private static TextView dungeon;
	private static TextView instance_reset;
	private static TextView instance_match;
	private static TextView instance_e_reset;
	private static TextView instance_e_match;

	private static AutoCompleteTextView edit;

	private static HashMap<String, String> isntance_norm = new HashMap<String, String>();
	private static HashMap<String, String> isntance_m_norm = new HashMap<String, String>();
	private static HashMap<String, String> e_isntance_norm = new HashMap<String, String>();
	private static HashMap<String, String> e_isntance_m_norm = new HashMap<String, String>();

	static DungeonCooldownFragment newInstance(int position, CharSequence text) {
		DungeonCooldownFragment frag = new DungeonCooldownFragment();
		Bundle args = new Bundle();

		args.putInt(KEY_POSITION, position);

		return (frag);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.dungeon_cd, container, false);

		initDungeons();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_dropdown_item_1line,
				new ArrayList<String>(isntance_norm.keySet()));

		dungeon = (TextView) result.findViewById(R.id.dungeon_name);
		instance_reset = (TextView) result.findViewById(R.id.instance_reset);
		instance_match = (TextView) result.findViewById(R.id.instance_m_reset);
		instance_e_reset = (TextView) result
				.findViewById(R.id.e_instance_reset);
		instance_e_match = (TextView) result
				.findViewById(R.id.e_instance_m_reset);

		edit = (AutoCompleteTextView) result.findViewById(R.id.edit);

		edit.addTextChangedListener(this);

		edit.setOnItemClickListener(this);

		edit.setAdapter(adapter);

		return (result);
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		dungeon.setText(edit.getText());
	}

	public void onItemClick(AdapterView<?> adapterView, View view,
			int position, long id) {
		String str = (String) adapterView.getItemAtPosition(position);
		instance_reset.setText(isntance_norm.get(str));
		instance_match.setText(isntance_m_norm.get(str));
		instance_e_reset.setText(e_isntance_norm.get(str));
		instance_e_match.setText(e_isntance_m_norm.get(str));
	}
	
	public void initDungeons() {
		isntance_norm.put("Bastion of Lok", "10 Minutes");
		isntance_m_norm.put("Bastion of Lok", "5 Minutes");
		e_isntance_norm.put("Bastion of Lok", "5 Minutes");
		e_isntance_m_norm.put("Bastion of Lok", "5 Minutes");

		isntance_norm.put("Sinestral Manor", "10 Minutes");
		isntance_m_norm.put("Sinestral Manor", "5 Minutes");
		e_isntance_norm.put("Sinestral Manor", "5 Minutes");
		e_isntance_m_norm.put("Sinestral Manor", "5 Minutes");

		isntance_norm.put("Cultist's Refuge", "10 Minutes");
		isntance_m_norm.put("Cultist's Refuge", "5 Minutes");
		e_isntance_norm.put("Cultist's Refuge", "5 Minutes");
		e_isntance_m_norm.put("Cultist's Refuge", "5 Minutes");

		isntance_norm.put("Necromancer Tomb", "10 Minutes");
		isntance_m_norm.put("Necromancer Tomb", "5 Minutes");
		e_isntance_norm.put("Necromancer Tomb", "5 Minutes");
		e_isntance_m_norm.put("Necromancer Tomb", "5 Minutes");

		isntance_norm.put("Sigil Adstringo", "10 Minutes");
		isntance_m_norm.put("Sigil Adstringo", "5 Minutes");
		e_isntance_norm.put("Sigil Adstringo", "5 Minutes");
		e_isntance_m_norm.put("Sigil Adstringo", "5 Minutes");

		isntance_norm.put("Golden Labryinth", "10 Minutes");
		isntance_m_norm.put("Golden Labryinth", "5 Minutes");
		e_isntance_norm.put("Golden Labryinth", "5 Minutes");
		e_isntance_m_norm.put("Golden Labryinth", "5 Minutes");

		isntance_norm.put("Akasha's Hideout", "10 Minutes");
		isntance_m_norm.put("Akasha's Hideout", "5 Minutes");
		e_isntance_norm.put("Akasha's Hideout", "5 Minutes");
		e_isntance_m_norm.put("Akasha's Hideout", "5 Minutes");

		isntance_norm.put("Akasha's Hideout (Hard Mode)", "10 Minutes");
		isntance_m_norm.put("Akasha's Hideout (Hard Mode)", "5 Minutes");
		e_isntance_norm.put("Akasha's Hideout (Hard Mode)", "5 Minutes");
		e_isntance_m_norm.put("Akasha's Hideout (Hard Mode)", "5 Minutes");

		isntance_norm.put("Ascent of Saravash", "10 Minutes");
		isntance_m_norm.put("Ascent of Saravash", "5 Minutes");
		e_isntance_norm.put("Ascent of Saravash", "5 Minutes");
		e_isntance_m_norm.put("Ascent of Saravash", "5 Minutes");

		isntance_norm.put("Saleron's Skygarden", "10 Minutes");
		isntance_m_norm.put("Saleron's Skygarden", "5 Minutes");
		e_isntance_norm.put("Saleron's Skygarden", "5 Minutes");
		e_isntance_m_norm.put("Saleron's Skygarden", "5 Minutes");

		isntance_norm.put("Suryati's Peak", "10 Minutes");
		isntance_m_norm.put("Suryati's Peak", "5 Minutes");
		e_isntance_norm.put("Suryati's Peak", "5 Minutes");
		e_isntance_m_norm.put("Suryati's Peak", "5 Minutes");

		isntance_norm.put("Temple of Temerity", "2 Hours");
		isntance_m_norm.put("Temple of Temerity", "1 Hour");
		e_isntance_norm.put("Temple of Temerity", "1 Hour");
		e_isntance_m_norm.put("Temple of Temerity", "1 Hour");

		isntance_norm.put("Ebon Tower", "10 Minutes");
		isntance_m_norm.put("Ebon Tower", "5 Minutes");
		e_isntance_norm.put("Ebon Tower", "5 Minutes");
		e_isntance_m_norm.put("Ebon Tower", "5 Minutes");

		isntance_norm.put("Ebon Tower (Hard)", "2 Hours");
		isntance_m_norm.put("Ebon Tower (Hard)", "1 Hour");
		e_isntance_norm.put("Ebon Tower (Hard)", "1 Hour");
		e_isntance_m_norm.put("Ebon Tower (Hard)", "1 Hour");

		isntance_norm.put("Kelsaik's Nest", "10 Minutes");
		isntance_m_norm.put("Kelsaik's Nest", "5 Minutes");
		e_isntance_norm.put("Kelsaik's Nest", "5 Minutes");
		e_isntance_m_norm.put("Kelsaik's Nest", "5 Minutes");

		isntance_norm.put("Kelsaik's Nest (Hard)", "6 Hours");
		isntance_m_norm.put("Kelsaik's Nest (Hard)", "6 Hours");
		e_isntance_norm.put("Kelsaik's Nest (Hard)", "3 Hours");
		e_isntance_m_norm.put("Kelsaik's Nest (Hard)", "3 Hours");

		isntance_norm.put("Labryinth of Terror", "10 Minutes");
		isntance_m_norm.put("Labryinth of Terror", "5 Minutes");
		e_isntance_norm.put("Labryinth of Terror", "5 Minutes");
		e_isntance_m_norm.put("Labryinth of Terror", "5 Minutes");

		isntance_norm.put("Labryinth of Terror (Hard)", "2 Hours");
		isntance_m_norm.put("Labryinth of Terror (Hard)", "1 Hour");
		e_isntance_norm.put("Labryinth of Terror (Hard)", "1 Hour");
		e_isntance_m_norm.put("Labryinth of Terror (Hard)", "1 Hour");

		isntance_norm.put("Balder's Temple", "2 Hours");
		isntance_m_norm.put("Balder's Temple", "1 Hour");
		e_isntance_norm.put("Balder's Temple", "1 Hour");
		e_isntance_m_norm.put("Balder's Temple", "1 Hour");

		isntance_norm.put("Balder's Temple(Hard)", "6 Hours");
		isntance_m_norm.put("Balder's Temple(Hard)", "6 Hours");
		e_isntance_norm.put("Balder's Temple(Hard)", "3 Hours");
		e_isntance_m_norm.put("Balder's Temple(Hard)", "3 Hours");

		isntance_norm.put("Fane of Kaprima", "2 Hours");
		isntance_m_norm.put("Fane of Kaprima", "1 Hour");
		e_isntance_norm.put("Fane of Kaprima", "1 Hour");
		e_isntance_m_norm.put("Fane of Kaprima", "1 Hour");

		isntance_norm.put("Fane of Kaprima (Hard Mode)", "6 Hours");
		isntance_m_norm.put("Fane of Kaprima (Hard Mode)", "6 Hours");
		e_isntance_norm.put("Fane of Kaprima (Hard Mode)", "3 Hours");
		e_isntance_m_norm.put("Fane of Kaprima (Hard Mode)", "3 Hours");

		isntance_norm.put("Argon Corpus", "2 Hours");
		isntance_m_norm.put("Argon Corpus",
				"Founder: 1 Hour, Non-Founder 2Hours");
		e_isntance_norm.put("Argon Corpus", "1 Hour");
		e_isntance_m_norm.put("Argon Corpus", "1 Hour");

		isntance_norm.put("Argon Corpus (Hard Mode)", "6 Hours");
		isntance_m_norm.put("Argon Corpus (Hard Mode)", "6 Hours");
		e_isntance_norm.put("Argon Corpus (Hard Mode)", "3 Hours");
		e_isntance_m_norm.put("Argon Corpus (Hard Mode)", "3 Hours");

		isntance_norm.put("Manaya's Core", "6 Hours");
		isntance_m_norm.put("Manaya's Core", "6 Hours");
		e_isntance_norm.put("Manaya's Core", "3 Hours");
		e_isntance_m_norm.put("Manaya's Core", "3 Hours");

		isntance_norm.put("Manaya's Core (Hard Mode)", "1 Entry per day");
		isntance_m_norm.put("Manaya's Core (Hard Mode)", "1 Entry per day");
		e_isntance_norm.put("Manaya's Core (Hard Mode)", "2 Entry per day");
		e_isntance_m_norm.put("Manaya's Core (Hard Mode)", "2 Entry per day");

		isntance_norm.put("Sirjuka Gallery", "3 Entry per day");
		isntance_m_norm.put("Sirjuka Gallery", "3 Entry per day");
		e_isntance_norm.put("Sirjuka Gallery", "6 Entry per day");
		e_isntance_m_norm.put("Sirjuka Gallery", "6 Entry per day");
		
		isntance_norm.put("Crucible of Flame", "1 Entry per day");
		isntance_m_norm.put("Crucible of Flame", "1 Entry per day");
		e_isntance_norm.put("Crucible of Flame", "2 Entry per day");
		e_isntance_m_norm.put("Crucible of Flame", "2 Entry per day");


	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	public void afterTextChanged(Editable s) {

	}
	
	

}
