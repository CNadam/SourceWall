package net.nashlegend.sourcewall.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.nashlegend.sourcewall.model.Article;
import net.nashlegend.sourcewall.view.ArticleListItemView;

/**
 * Created by NashLegend on 2014/9/18 0018
 */
public class ArticleAdapter extends AceAdapter<Article> {

    public ArticleAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new ArticleListItemView(getContext());
        }
        ((ArticleListItemView) convertView).setData(list.get(position));
        return convertView;
    }
}
