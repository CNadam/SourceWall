package net.nashlegend.sourcewall.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.nashlegend.sourcewall.model.Post;
import net.nashlegend.sourcewall.view.AceView;
import net.nashlegend.sourcewall.view.PostListItemView;

/**
 * Created by NashLegend on 2014/9/15 0015
 */
public class PostAdapter extends AceAdapter<Post> {

    public PostAdapter(Context context) {
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
            convertView = new PostListItemView(getContext());
        }
        ((AceView) convertView).setData(list.get(position));
        return convertView;
    }
}
