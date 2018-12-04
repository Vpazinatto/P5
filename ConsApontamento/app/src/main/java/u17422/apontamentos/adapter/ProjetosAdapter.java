package u17422.apontamentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import u17422.apontamentos.R;
import u17422.apontamentos.modelo.Projeto;

import java.util.List;

public class ProjetosAdapter extends BaseAdapter {

    private final List<Projeto> projetos;
    private final Context context;

    public ProjetosAdapter(Context context ,List<Projeto> projetos)
    {
        this.projetos = projetos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*Projeto projeto = projetos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout., parent, false);
        }

        TextView campoNomeProjeto = (TextView) view.findViewById(R.id.);
        campoNomeProjeto.setText(projeto.getNome());*/

        return convertView;
    }
}
