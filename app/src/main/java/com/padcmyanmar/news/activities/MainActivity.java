package com.padcmyanmar.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.padcmyanmar.news.MMNewsApp;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.InternationalNewsAdapter;
import com.padcmyanmar.news.adapters.NewsAdapter;
import com.padcmyanmar.news.data.models.LoginUserModel;
import com.padcmyanmar.news.data.models.NewsModel;
import com.padcmyanmar.news.delegates.BeforeLoginDelegate;
import com.padcmyanmar.news.delegates.LoginUserDelegate;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import com.padcmyanmar.news.events.LoadedNewsEvent;
import com.padcmyanmar.news.viewpod.AccountControlViewPod;
import com.padcmyanmar.news.viewpod.BeforeLoginViewPod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NewsActionDelegate, BeforeLoginDelegate, LoginUserDelegate {

    @BindView(R.id.rv_news) //3.put id in bindview
            RecyclerView rvNews; //4. put the value into java variable

    @BindView(R.id.toolbar)
    Toolbar toolBar;

    @BindView(R.id.fab)
    FloatingActionButton fActionButton;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private NewsAdapter mNewsAdapter;

    private AccountControlViewPod vpAccountControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. initialize buterknife
        ButterKnife.bind(this, this);

        setSupportActionBar(toolBar);

        mNewsAdapter = new NewsAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        rvNews.setLayoutManager(linearLayoutManager);

       /* GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        rvNews.setLayoutManager(gridLayoutManager);*/

        rvNews.setAdapter(mNewsAdapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              /*  item.setChecked(true);
                Intent intent = NewsByCategoryActivity.newIntent(getApplicationContext());
                startActivity(intent);*/
                if (item.getItemId() == R.id.menu_news_by_categories) {

                    item.setChecked(true);
                    Intent intent = NewsByCategoryActivity.newIntent(getApplicationContext());
                    startActivity(intent);

                } else if ((item.getItemId() == R.id.menu_all_news)) {
                    item.setChecked(true);
                    Intent intent = MainActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;

            }
        });

        vpAccountControl = (AccountControlViewPod) navigationView.getHeaderView(0);

        vpAccountControl.setDelegate(this);

        vpAccountControl.setLoginUserDelegate(this);

        NewsModel.getsObjInstance().loadNews();


    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTapTab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onTapNewsItem() {
        Intent intent = new Intent(getApplication(), NewsDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavoriteButton() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {

        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded : " + event.getNewsVOList().size());
        mNewsAdapter.setNews(event.getNewsVOList());
    }

    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {
        Intent intent = AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapLogout() {
        LoginUserModel.getsObjInstance().logout();
    }
}
