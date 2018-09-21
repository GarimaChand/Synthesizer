package co.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttona2;
    private Button buttonb2;
    private Button buttonbb2;
    private Button buttonc2;
    private Button buttoncs2;
    private Button buttond2;
    private Button buttonds2;
    private Button buttone2;
    private Button buttonf2;
    private Button buttonfs2;
    private Button buttong2;
    private Button buttongs2;

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int notea2;
    private int noteb2;
    private int notebb2;
    private int notec2;
    private int notecs2;
    private int noted2;
    private int noteds2;
    private int notee2;
    private int notef2;
    private int notefs2;
    private int noteg2;
    private int notegs2;
    private Map<Integer, Integer> noteMap;


    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final int DEFAULT_RATE = 1;
    public static final int WHOLE_NOTE = 1000; // in ms


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgetes();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        //ina a map you store a a key value pair
        //key is the button ID, the value is the noteID
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_a2, notea2);
        noteMap.put(R.id.button_synth_bb2, notebb2);
        noteMap.put(R.id.button_synth_b2, noteb2);
        noteMap.put(R.id.button_synth_c2, notec2);
        noteMap.put(R.id.button_synth_cs2, notecs2);
        noteMap.put(R.id.button_synth_d2, noted2);
        noteMap.put(R.id.button_synth_ds2, noteds2);
        noteMap.put(R.id.button_synth_e2, notee2);
        noteMap.put(R.id.button_synth_f2, notef2);
        noteMap.put(R.id.button_synth_fs2, notefs2);
        noteMap.put(R.id.button_synth_g2, noteg2);
        noteMap.put(R.id.button_synth_gs2, notegs2);
    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10,
                AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);
        notea2 = soundPool.load(this, R.raw.scalegs, 1);
        noteb2 = soundPool.load(this, R.raw.scalegs, 1);
        notebb2 = soundPool.load(this, R.raw.scalegs, 1);
        notec2 = soundPool.load(this, R.raw.scalegs, 1);
        notecs2 = soundPool.load(this, R.raw.scalegs, 1);
        noted2 = soundPool.load(this, R.raw.scalegs, 1);
        noteds2 = soundPool.load(this, R.raw.scalegs, 1);
        notee2 = soundPool.load(this, R.raw.scalegs, 1);
        notef2 = soundPool.load(this, R.raw.scalegs, 1);
        notefs2 = soundPool.load(this, R.raw.scalegs, 1);
        noteg2 = soundPool.load(this, R.raw.scalegs, 1);
        notegs2 = soundPool.load(this, R.raw.scalegs, 1);

    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttona2.setOnClickListener(noteListener);
        buttonb2.setOnClickListener(noteListener);
        buttonbb2.setOnClickListener(noteListener);
        buttonc2.setOnClickListener(noteListener);
        buttoncs2.setOnClickListener(noteListener);
        buttond2.setOnClickListener(noteListener);
        buttone2.setOnClickListener(noteListener);
        buttonf2.setOnClickListener(noteListener);
        buttonfs2.setOnClickListener(noteListener);
        buttong2.setOnClickListener(noteListener);
        buttongs2.setOnClickListener(noteListener);
        //buttonScale.setOnClickListener(noteListener);
    }

    private void wireWidgetes() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttona2 = findViewById(R.id.button_synth_a2);
        buttonb2 = findViewById(R.id.button_synth_b2);
        buttonbb2 = findViewById(R.id.button_synth_bb2);
        buttonc2 = findViewById(R.id.button_synth_c2);
        buttoncs2 = findViewById(R.id.button_synth_cs2);
        buttond2 = findViewById(R.id.button_synth_d2);
        buttone2 = findViewById(R.id.button_synth_e2);
        buttonf2 = findViewById(R.id.button_synth_f2);
        buttonfs2 = findViewById(R.id.button_synth_fs2);
        buttong2 = findViewById(R.id.button_synth_g2);
        buttongs2 = findViewById(R.id.button_synth_gs2);

    }

    @Override
    public void onClick(View v) {
        //one of the method to handle the clicks of all
        //don't forget that the button is doing the listening
        switch (v.getId()) {
            case R.id.button_main_scale:
                try {
                    playScale();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
    private void playScale() throws InterruptedException {
        //play all the notes one at a time w delay in bet.
        Song scale = new Song();
        List<Note> notes = new ArrayList<>();
        // below notes for twinkle twinkle little star
        scale.add(new Note(noteF, Note.WHOLE_NOTE /2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE /2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE /2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE /2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        playSong(scale);

        //song # 2 below....
        // FIRST SET: HAPPY BIRTHDAY TO YOU
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));

        //SECOND SET: HAPPY BIRTHDAY TO YOU
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));

        //THIRD SET: HAPPY BIRTHDAY DEAR [NAME]
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));

        //FOURTH SET: HAPPY BIRTHDAY TO YOU
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));




        //Thousand Years
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(notee2, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteE, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteB, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteF, Note.WHOLE_NOTE / 2));
        scale.add(new Note(notee2, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteFs, Note.WHOLE_NOTE / 2));
        scale.add(new Note(notee2, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteC, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteD, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        /// delayyyyy
        scale.add(new Note(noteG, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteBb, Note.WHOLE_NOTE / 2));
        scale.add(new Note(noteA, Note.WHOLE_NOTE / 2));
        
    }

    private void playSong(Song song) {
        for (Note note : song.getNotes()) {
            playNote(note.getNoteId(), 1);
            delay(note.getDelay());
        }

    }
    private void challenge(Challenge challenge){
        for(Note note : playSong().getNotes()){
            playNote(note.getNoteId(),1);
            delay(note.getDelay());
        }
    }
    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int noteA, int loop) {
        soundPool.play(noteA, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY,
                loop, DEFAULT_RATE);
    }

    private void playNote(int note) {
        playNote(note, 0);
    }

    private void playNote(Note note) {
        playNote(note.getNoteId(), 0);
    }


    //make a inner class to handle the button clicks for individual notes
    private class KeyboardNoteListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //get the id of the button that was clicked
            int id = v.getId();
            //use the map to figure out what note to play
            int note = noteMap.get(id);
            // play the note
            playNote(note);

        }
    }


}
