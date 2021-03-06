package com.example.ben.moviesdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "movie";
    public String year2;
    TextView year;
    ImageView poster;
    TextView title;
    TextView description;
    TextView average;
    private Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_delegate);

        if (getIntent().hasExtra(EXTRA_MOVIE)) {
            mMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        } else {
            throw new IllegalArgumentException("Detail activity must receive a movie parcelable");
        }

        poster = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.movieTittle);
        description = (TextView) findViewById(R.id.textSummary);
        year = (TextView) findViewById(R.id.textYear);
        average = (TextView) findViewById(R.id.textView2);

        title.setText(mMovie.getTitle());
        description.setText(mMovie.getDescription());
        year2 = mMovie.getYear();
        year2 = year2.substring(0, 4);
        year.setText(year2);
        average.setText(mMovie.getAverage() + "/10");

        Picasso.with(this)
                .load(mMovie.getPoster())
                .into(poster);
    }
}