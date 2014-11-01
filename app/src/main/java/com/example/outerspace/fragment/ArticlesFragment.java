package com.example.outerspace.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.outerspace.ArticleActivity;
import com.example.outerspace.R;
import com.example.outerspace.adapters.ArticleAdapter;
import com.example.outerspace.commonview.LListView;
import com.example.outerspace.connection.ResultObject;
import com.example.outerspace.connection.api.ArticleAPI;
import com.example.outerspace.model.Article;
import com.example.outerspace.model.SubItem;
import com.example.outerspace.util.Consts;
import com.example.outerspace.view.ArticleListItemView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by NashLegend on 2014/9/18 0018
 */
public class ArticlesFragment extends ChannelsFragment implements LListView.OnRefreshListener {

    private String defaultChannel = "hot";
    private LListView listView;
    private ArticleAdapter adapter;
    private LoaderTask task;
    private SubItem subItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        subItem = (SubItem) getArguments().getSerializable(Consts.Extra_SubItem);
        listView = (LListView) view.findViewById(R.id.list_articles);
        adapter = new ArticleAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ArticleActivity.class);
                intent.putExtra(Consts.Extra_Article, ((ArticleListItemView) view).getArticle());
                startActivity(intent);
            }
        });
        task = new LoaderTask();
        RequestData requestData = new RequestData();
        requestData.isChannel = true;
        requestData.isLoadMore = false;
        requestData.key = defaultChannel;
        requestData.offset = 0;
        task.execute(requestData);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onRefresh() {
        //TODO
    }

    @Override
    public void onLoadMore() {
        //TODO
    }

    @Override
    public View resetData(SubItem subItem) {
        return null;
    }

    class LoaderTask extends AsyncTask<RequestData, Integer, ResultObject> {

        RequestData data;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ResultObject doInBackground(RequestData... datas) {
            data = datas[0];
            ArrayList<Article> articles = new ArrayList<Article>();
            ResultObject resultObject = new ResultObject();
            try {
                if (data.isChannel) {
                    articles = ArticleAPI.getArticleListByChannel(data.key, data.offset);
                } else {
                    articles = ArticleAPI.getArticleListBySubject(data.key, data.offset);
                }
                resultObject.result = articles;
                if (articles != null) {
                    resultObject.ok = true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultObject;
        }

        @Override
        protected void onPostExecute(ResultObject o) {
            if (o.ok) {
                ArrayList<Article> ars = (ArrayList<Article>) o.result;
                if (data.isLoadMore) {
                    if (ars.size() > 0) {
                        adapter.addAll(ars);
                    } else {

                    }
                } else {
                    if (ars.size() > 0) {
                        adapter.setList(ars);
                    } else {

                    }
                }
                adapter.notifyDataSetChanged();
            } else {

            }
        }
    }

    class RequestData {
        boolean isLoadMore = false;
        boolean isChannel = true;
        String key = "";
        int offset = 0;
    }


}
