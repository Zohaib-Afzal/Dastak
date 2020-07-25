package com.dastak.dastak.ui.drugsInformation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dastak.dastak.R;

public class DrugsInformation extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drugs_information, container, false);
         TextView mainTextView = root.findViewById(R.id.main_text_drugs_info);
         TextView facilitiesTextView = root.findViewById(R.id.facilities);
        TextView benefitsOfRehabTextView = root.findViewById(R.id.benefits_of_rehab);


        String mainTextValue = "Any person who is battling to quit consuming drugs and is enduring truly, intellectually, monetarily, socially and sincerely subsequently would positively profit by and actual existence sparing medication recovery program.\n" +
                "\n" +
                "The Good Life Center use proof-based fixation medicines to guarantee that you have the devices and attention to keep up your recuperation and remain clean after on from our medication recovery. We offer individual concussed treatment that will assist you with healing on each level.\n" +
                "Detoxing form drug is insufficient for most edicts, the depend mind should be revamped utilizing all-encompassing and remedial models to carry on with a real existence liberated from drugs and addictive practices.\n" +
                "Our world-class group of mindful and profoundly talented staff genuinely comprehend the idea of fixation and how to adequately treat it. We are her to help. ";
        mainTextView.setText(mainTextValue);
        String facilitiesTextValue = "- Bed Rooms\n\n" +
                "- Living Area\n\n" +
                "- Counseling Room / Theraphy\n\n" +
                "- Library\n\n" +
                "- Gym and Yoga\n\n" +
                "- Nutrition and Cafe\n\n" +
                "- Clinic\n\n" +
                "- Lab\n\n" +
                "- Prayer Room\n\n" +
                "- Game Room\n\n" +
                "- Conference Room\n\n" +
                "- Outdoor Garden";
        facilitiesTextView.setText(facilitiesTextValue);
        String benefitsOfRehabValue = ". 24/7 professional care around the clock                 \n" +
                "  during a medical drug detox\n" +
                "\n" +
                ". A compassionate, recovery-focused rehab           \n" +
                "  environment in which to heal\n" +
                "\n" +
                ". 24/7 professional care around the clock \n" +
                "  during a medical drug detox\n" +
                "\n" +
                ". A free comprehensive aftercare package";
        benefitsOfRehabTextView.setText(benefitsOfRehabValue);

        return root;
    }
}