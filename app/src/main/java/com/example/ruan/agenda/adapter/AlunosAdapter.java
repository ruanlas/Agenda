package com.example.ruan.agenda.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruan.agenda.R;
import com.example.ruan.agenda.modelo.Aluno;

import java.util.List;

public class AlunosAdapter extends BaseAdapter {

    private List<Aluno> alunoList;
    private Context context;

    public AlunosAdapter(Context context, List<Aluno> alunoList){
        this.alunoList = alunoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunoList.size();
    }

    @Override
    public Object getItem(int position) {
        return alunoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunoList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_view_item_aluno, parent, false);
        }

        TextView item_nome = (TextView)convertView.findViewById(R.id.item_nome);
        TextView item_telefone = (TextView)convertView.findViewById(R.id.item_telefone);
        ImageView item_foto = (ImageView)convertView.findViewById(R.id.item_foto);

        item_nome.setText( alunoList.get(position).getNome() );
        item_telefone.setText( alunoList.get(position).getTelefone() );

        String caminhoFoto = alunoList.get(position).getCaminhoFoto();
        if (caminhoFoto != null){
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduced = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            item_foto.setImageBitmap(bitmapReduced);
            item_foto.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        return convertView;
    }
}
