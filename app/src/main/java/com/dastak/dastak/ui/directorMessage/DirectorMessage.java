package com.dastak.dastak.ui.directorMessage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;

public class DirectorMessage extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_director_message, container, false);
        final TextView mainText = root.findViewById(R.id.main_text_director_message);
        String mainTextValue = "The Good Life Foundation calls on young people, who are particularly vulnerable to drug use, to face the truth about drugs. Under our three programs, our main aim is to increase the living standards of the people of our country, specially youth and help them establish themselves to compete in the job and business communities. The prevalence of drug use among young people is more than twice as high as that among the general population. Peer pressure to experiment with illicit drugs can be strong, and self-esteem is often low in this age group. Also, those who take illicit drugs tend to be either misinformed or insufficiently aware of the health risks involved.\n" +
                "\n" +
                "Today the youth of Pakistan has become the target of major drug peddlers. These peddlers sell drugs and package them as symbols of revolution and freshness but have no regard for the consequences of their actions.\n" +
                "\n" +
                "It is time that Pakistan takes a firmer view about preventing and stopping drug addiction. Drug Free World- Pakistan is ready with a community plan that should be implemented to stop addiction to drugs. It is built on existing resources and has developed short-term and long-term goals.\n" +
                "\n" +
                "I urge you to please join hands with us because unless serious measures are taken now, the very future of a large chunk of today's youth will be severely compromised. The problem of drug addiction is too real and serious to be ignored. The foundation has taken up the responsibility to highlight such issues to educate people and build a consensus among them to build a united stand against such courage.";
        mainText.setText(mainTextValue);
        return root;
    }
}