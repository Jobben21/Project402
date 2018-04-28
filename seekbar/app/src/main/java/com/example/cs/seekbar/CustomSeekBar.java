package com.example.cs.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomSeekBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_seek_bar);

        int progressBarWidth = getWidth();
        int progressBarHeight = getHeight();
        int thumboffset = getThumbOffset();
        int lastProgressX = 0;
        int progressItemWidth, progressItemRight;
        for (int i = 0; i < mProgressItemsList.size(); i++) {
            ProgressItem progressItem = mProgressItemsList.get(i);
            Paint progressPaint = new Paint();
            progressPaint.setColor(getResources().getColor(progressItem.color));

            progressItemWidth = (int) (progressItem.progressItemPercentage
                    * progressBarWidth / 100);

            progressItemRight = lastProgressX + progressItemWidth;

            // for last item give right of the progress item to width of the
            // progress bar
            if (i == mProgressItemsList.size() - 1
                    && progressItemRight != progressBarWidth) {
                progressItemRight = progressBarWidth;
            }
            Rect progressRect = new Rect();
            progressRect.set(lastProgressX, thumboffset / 2, progressItemRight,
                    progressBarHeight - thumboffset / 2);
            canvas.drawRect(progressRect, progressPaint);
            lastProgressX = progressItemRight;
        }
        super.onDraw(canvas);
    }
    }
}
