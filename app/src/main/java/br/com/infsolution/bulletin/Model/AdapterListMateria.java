package br.com.infsolution.bulletin.Model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import br.com.infsolution.bulletin.Model.Materia;
import br.com.infsolution.bulletin.R;

/**
 * Created by Cicero on 30/03/2016.
 */
public class AdapterListMateria extends ArrayAdapter<Materia> {
    private final List<Materia> materias;
    private final Activity activity;
    public AdapterListMateria(Activity activity, int textViewResourceId, List<Materia> materias) {
        super(activity, textViewResourceId, materias);
        this.activity=activity;
        this.materias=materias;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Materia materia = materias.get(position);

        View view = activity.getLayoutInflater().inflate(R.layout.item_list, null);

        RelativeLayout fundo = (RelativeLayout) view.findViewById(R.id.fundo_list_item);
        if (position % 2 == 0) {
            fundo.setBackgroundColor(0xffff0000);
        } else {
            fundo.setBackgroundColor(0xff00ff00);
        }

        ImageView foto = (ImageView) view.findViewById(R.id.image_materia);
        Bitmap bm = BitmapFactory.decodeResource(activity.getResources(), R.drawable.icon_agenda);
        if (materia.getFoto() != null) {
            bm = BitmapFactory.decodeFile(materia.getFoto());
        }
        bm = Bitmap.createScaledBitmap(bm, 100, 100, true);
        foto.setImageBitmap(bm);
        TextView nome = (TextView) view.findViewById(R.id.txt_nome_materia);
        nome.setText(materia.toString());

        return view;
    }

    @Override
    public long getItemId(int position) {
        return materias.get(position).getId();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Materia getItem(int position) {
        return materias.get(position);
    }
}
