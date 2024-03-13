import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.a7boxlauncher.R;

import java.util.List;

public class AppsAdapter extends BaseAdapter {

    private Context context;
    private List<ApplicationInfo> apps;

    public AppsAdapter(Context context, List<ApplicationInfo> apps) {
        this.context = context;
        this.apps = apps;
    }

    @Override
    public int getCount() {
        return apps.size();
    }

    @Override
    public Object getItem(int position) {
        return apps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        }

        ImageView icon = view.findViewById(R.id.icon);
        TextView name = view.findViewById(R.id.name);

        ApplicationInfo app = apps.get(position);

        try {
            icon.setImageDrawable(context.getPackageManager().getApplicationIcon(app.packageName));
        } catch (PackageManager.NameNotFoundException e) {
            // Lidar com a exceção aqui
            // Por exemplo, exibir um ícone padrão
            icon.setImageResource(android.R.drawable.ic_menu_report_image); // Substitua pelo seu recurso de ícone padrão
            e.printStackTrace();
        }

        name.setText(app.loadLabel(context.getPackageManager()).toString());

        return view;
    }

}
