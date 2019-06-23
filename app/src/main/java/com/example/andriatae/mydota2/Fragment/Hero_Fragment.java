//package com.example.andriatae.mydota2.Fragment;
//
///**
// * Created by Andria TAE on 20/03/2018.
// */
//
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.andriatae.mydota2.Adapters.RecycleClickListener;
//import com.example.andriatae.mydota2.Adapters.Recycle_Adapter_Heroes;
//import com.example.andriatae.mydota2.Application.myApplication;
//import com.example.andriatae.mydota2.R;
//import com.example.andriatae.mydota2.View_Presenter.Fragment_Interface;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
////package com.example.andriatae.mydota2.Fragment;
//
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
////import com.example.andriatae.mydota2.R;
//
//
///**
// * Created by Andria TAE on 17/03/2018.
// */
//
//public class Hero_Fragment extends Fragment implements SpecialisedFragmentScripture {
//
//
//
//
//
//
//
//
//
//   myApplication mainApp;
//   Activity myActivity;
//   Fragment_Interface myScript;
//
//   Recycle_Adapter_Heroes adapter;
//
//
//
//
//
//    public Hero_Fragment() {
//
//        mainApp=myApplication.get();
//
//
//    }
//
//
//
//    private void loadHeroesIntoView() {
//
//
//
//
//            }
//
//
//
//
//
//
//    public static Hero_Fragment newInstance(int profileId) {
//
//        Hero_Fragment thisUser = new Hero_Fragment();
//
//        Bundle myTreasureChest = new Bundle();
//
//        myTreasureChest.putInt("Profile_ID", profileId);
//
//        thisUser.setArguments(myTreasureChest);
//
//        return thisUser;
//
//    }
//
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//
//        this.myActivity=activity;
//        myScript= (Fragment_Interface) activity;
//
//
//
//
//
//    }
//
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        mainApp=myApplication.get();
//
//
//        loadHeroesIntoView();
//
//
//        System.out.println("have skipped execute");
//
//    }
//
//
//
//
//    //check to see if there are players in the database
//
//
//
//
//
//
//
//    @Override
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.my_user_profile, container, false);
//
//        ButterKnife.bind(this, rootView);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(strength_recycle.getContext(), LinearLayoutManager.HORIZONTAL, false);
//
//        strength_recycle.addItemDecoration(new DividerItemDecoration(getActivity(),
//                DividerItemDecoration.HORIZONTAL));
//        strength_recycle.setLayoutManager(layoutManager);
//
//        agility_recycle.addItemDecoration(new DividerItemDecoration(getActivity(),
//                DividerItemDecoration.HORIZONTAL));
//        agility_recycle.setLayoutManager(layoutManager);
//        intelligence_recycle.addItemDecoration(new DividerItemDecoration(getActivity(),
//                DividerItemDecoration.HORIZONTAL));
//        intelligence_recycle.setLayoutManager(layoutManager);
//
//
//
//        RecycleClickListener listener = new RecycleClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                System.out.println("its been clicked");
//
//
//            }
//        };
//
//
//            Recycle_Adapter_Heroes adapterStr=new Recycle_Adapter_Heroes(listener,"Strength");
//
//            strength_recycle.setAdapter(adapter);
//        Recycle_Adapter_Heroes adapterAgil=new Recycle_Adapter_Heroes(listener,"Strength");
//
//        agility_recycle.setAdapter(adapter);
//        Recycle_Adapter_Heroes adapterSInteli=new Recycle_Adapter_Heroes(listener,"Strength");
//
//        intelligence_recycle.setAdapter(adapter);
//
//
//        return rootView;
//    }
//
//
//
//    public void refreshFrame()
//    {
//        Fragment currentFragment =this;
//
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//
//        fragmentTransaction.detach(currentFragment);
//        fragmentTransaction.attach(currentFragment);
//        fragmentTransaction.commit();
//
//
//
//    }
//
//    @Override
//    public void initMatchValuesToSHow() {
//
//    }
//
//
//}
//
//
//
