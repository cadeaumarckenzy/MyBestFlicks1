package e.elkulep10.flicks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends ArrayAdapter<User>{
    public UsersAdapter(@NonNull Context context, ArrayList<User> users) {
        super(context, R.layout.item_user, users);
    }

    private static class ViewHolder{
        TextView Name;
        TextView Home;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder.Name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.Home = (TextView) convertView.findViewById(R.id.tvHome);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.Name.setText(user.Name);
        viewHolder.Home.setText(user.Home);
        return convertView;
    }


}
