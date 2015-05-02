package com.sn.scottnumamoto.bell;

import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.TimerTask;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    final boolean FRIEND_VERSION = false;

    ImageView edit;
    TextView button;
    LinearLayout cardDeck;
    TextSwitcher textSwitcher;

    Schedule currentSchedule = new Schedule();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        synthesize();

        //Color top image blue
        edit = (ImageView) findViewById(R.id.topImage);
        edit.setColorFilter(this.getResources().getColor(R.color.numa_secondary), PorterDuff.Mode.MULTIPLY);


        // get a TextSwitcher view; instantiate in code or resolve from a layout/XML
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setOnClickListener(this);


        // provide two TextViews for the TextSwitcher to use
        // you can apply styles to these Views before adding
        TextView a = new TextView(this);
        a.setGravity(Gravity.CENTER);
        a.setTextAppearance(this, android.R.style.TextAppearance_Large);
        a.setTextColor(this.getResources().getColor(R.color.numa_primary));

        TextView b = new TextView(this);
        b.setGravity(Gravity.CENTER);
        b.setTextAppearance(this, android.R.style.TextAppearance_Large);
        b.setTextColor(this.getResources().getColor(R.color.numa_primary));

        textSwitcher.addView(a);
        textSwitcher.addView(b);




        refresh();

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(60 * 1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refresh();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    public void onResume()
    {
        super.onResume();
        refresh();
    }

    public void onClick(View v) {

        refresh();
    }

    private void synthesize()
    {
        cardDeck = (LinearLayout) findViewById(R.id.card_deck);

        int set = (int) this.getResources().getDimension(R.dimen.numa_margin);
        setMargins(cardDeck, set, -150, set, set);

        Period[] list;
        try {
            list = currentSchedule.nextPeriods();

            for (int i = 0; i < list.length; i++) {
                Period morePeriods = list[i];


                View childLayout = getLayoutInflater().inflate(R.layout.card_template, null);


                ViewGroup sort = (ViewGroup) childLayout;
                CardView childCard = (CardView) sort.getChildAt(0);
                childCard.setPreventCornerOverlap(false);

                ViewGroup sort2 = (ViewGroup) childCard;
                View childCardArrange = sort2.getChildAt(0);

                ViewGroup sort3 = (ViewGroup) childCardArrange;
                ImageView childCardImage = (ImageView) sort3.getChildAt(0);
                childCardImage.setImageResource(selectBackground(morePeriods.getLabel()));

                View childCardText = sort3.getChildAt(1);

                ViewGroup sort4 = (ViewGroup) childCardText;
                TextView childPeriodName = (TextView) sort4.getChildAt(0);
                childPeriodName.setText(morePeriods.getLabel());

                TextView childPeriodDuration = (TextView) sort4.getChildAt(1);
                childPeriodDuration.setText(morePeriods.getDuration());

                cardDeck.addView(childLayout);
            }
        }
        catch (IllegalStateException i){

        }
    }

    private int cycleIterator (int i, int length){
        Date d = new Date();
        int gap = d.getDay();

        int result = (gap + i) % length;

        if (result > 34)
        {
            throw new ArrayIndexOutOfBoundsException("#BAD MOVE");
        }
        return result;
    }
    private int selectBackground( String label )
    {


        int[] landscapes = {
                R.drawable.m01,
                R.drawable.m02,
                R.drawable.m03,
                R.drawable.m04,
                R.drawable.m05,
                R.drawable.m06,
                R.drawable.m07,
                R.drawable.m08,
                R.drawable.m09,
                R.drawable.m10,
                R.drawable.m11,
                R.drawable.m12,
                R.drawable.m13,
                R.drawable.m14,
                R.drawable.m15,
                R.drawable.n01,
                R.drawable.n02,
                R.drawable.n03,
                R.drawable.n04,
                R.drawable.n05,
                R.drawable.n06,
                R.drawable.n07,
                R.drawable.n08,
                R.drawable.n09,
                R.drawable.n10,
                R.drawable.n11,
                R.drawable.n12,
                R.drawable.n13,
                R.drawable.n14,
                R.drawable.n15,
                R.drawable.n16,
                R.drawable.n17,
                R.drawable.n18,
                R.drawable.n19,
                R.drawable.n20
        };

        final int[] images;

        images = landscapes;

        try {
            switch (label) {
                case "1":
                    return images[cycleIterator(0, images.length)];
                case "2":
                    return images[cycleIterator(1, images.length)];
                case "Snack":
                    return images[cycleIterator(2, images.length)];
                case "3":
                    return images[cycleIterator(3, images.length)];
                case "Tutorial":
                    return images[cycleIterator(4, images.length)];
                case "4":
                    return images[cycleIterator(5, images.length)];
                case "Lunch":
                    return images[cycleIterator(6, images.length)];
                case "5":
                    return images[cycleIterator(7, images.length)];
                case "6":
                    return images[cycleIterator(8, images.length)];
                case "7":
                    return images[cycleIterator(9, images.length)];
                case "8":
                    return images[cycleIterator(10, images.length)];
                case "9":
                    return images[cycleIterator(11, images.length)];
                case "10":
                    return images[cycleIterator(12, images.length)];
                case "11":
                    return images[cycleIterator(13, images.length)];
                case "12":
                    return images[cycleIterator(14, images.length)];
                case "13":
                    return images[cycleIterator(15, images.length)];
                case "14":
                    return images[cycleIterator(16, images.length)];
                case "15":
                    return images[cycleIterator(17, images.length)];
                case "16":
                    return images[cycleIterator(18, images.length)];
                case "17":
                    return images[cycleIterator(19, images.length)];
                case "18":
                    return images[cycleIterator(20, images.length)];
                case "19":
                    return images[cycleIterator(21, images.length)];
                case "20":
                    return images[cycleIterator(22, images.length)];
                case "21":
                    return images[cycleIterator(23, images.length)];
                case "22":
                    return images[cycleIterator(24, images.length)];
                case "23":
                    return images[cycleIterator(25, images.length)];
                case "24":
                    return images[cycleIterator(26, images.length)];
                case "Final":
                    return images[cycleIterator(27, images.length)];
                default:
                    return images[cycleIterator(28, images.length)];

            }
        }



        catch ( IndexOutOfBoundsException i )
        {
            return images[0];
        }
    }


    private void printID(View v)
    {
        int x = v.getId();
    }

    private View cardPart(View childLayout, String part)
    {
        ViewGroup sort = (ViewGroup) childLayout;
        CardView childCard = (CardView) sort.getChildAt(0);


        ViewGroup sort2 = (ViewGroup) childCard;
        View childCardArrange = sort2.getChildAt(0);

        ViewGroup sort3 = (ViewGroup) childCardArrange;
        View childCardImage = sort3.getChildAt(0);
        View childCardText = sort3.getChildAt(1);

        ViewGroup sort4 = (ViewGroup) childCardText;
        View childPeriodName = sort4.getChildAt(0);

        View childPeriodDuration = sort4.getChildAt(1);

        switch (part)
        {
            case "card":
                return childCard;
            case "cardArragne":
                return childCardArrange;
            case "cardImage":
                return childCardImage;
            case "cardText":
                return childCardText;
            case "periodName":
                return childPeriodName;
            case "periodDuration":
                return childPeriodDuration;
            default:
                throw new IllegalStateException ("Not an actual card segment");
        }
    }

    private void setRemainderBoxDimen()
    {
        //Sets the dimensions of the Layout that contains the remainder bubble in it
        final int widthFactor = 3;
        final int heightFactor = 2;

        final RelativeLayout mFrame = (RelativeLayout) findViewById(R.id.topHolder);

        mFrame.post(new Runnable() {

            @Override
            public void run() {
                LinearLayout.LayoutParams mParams;
                mParams = (LinearLayout.LayoutParams) mFrame.getLayoutParams();

                //Critical Step
                mParams.height = mFrame.getWidth() / widthFactor * heightFactor;
                mFrame.setLayoutParams(mParams);
                mFrame.postInvalidate();
            }
        });
    }

    private void updateTime()
    {
        try {
            textSwitcher.setText(currentSchedule.remainingTime() + "");
        } catch (IllegalStateException i ) {
            textSwitcher.setText("*");
        }

    }

    private void removeOldCards()
    {
        try{
            for (int i = 0; i < cardDeck.getChildCount(); i++)
            {
                View cardSet = cardDeck.getChildAt(i);
                String label = getPeriodLabel(cardSet);
                Period p = currentSchedule.getPeriodByName(label);
                if (currentSchedule.passedPeriod(p))
                {
                    cardDeck.removeViewAt(i);
                }

            }
        }
        catch (NullPointerException n)
        {
            int a = 4;
        }

    }

    class RefreshRepeat extends TimerTask {
        public void run() {
            refresh();
        }
    }

    public void refresh()
    {
        updateTime();
        removeOldCards();
    }

    private String getPeriodLabel(View cardSet)
    {
        View childLayout = cardSet;


        ViewGroup sort = (ViewGroup) childLayout;
        CardView childCard = (CardView) sort.getChildAt(0);
        childCard.setPreventCornerOverlap(false);

        ViewGroup sort2 = (ViewGroup) childCard;
        View childCardArrange = sort2.getChildAt(0);

        ViewGroup sort3 = (ViewGroup) childCardArrange;
        View childCardText = sort3.getChildAt(1);

        ViewGroup sort4 = (ViewGroup) childCardText;
        TextView childPeriodName = (TextView) sort4.getChildAt(0);
        return childPeriodName.getText() + "";
    }



    private static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }












}
