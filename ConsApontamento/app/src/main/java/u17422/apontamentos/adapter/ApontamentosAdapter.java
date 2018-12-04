package u17422.apontamentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import u17422.apontamentos.R;
import u17422.apontamentos.modelo.Apontamento;

import java.util.List;

public class ApontamentosAdapter extends BaseAdapter {

    private final List<Apontamento> apontamentos;
    private final Context context;

    public ApontamentosAdapter(Context context ,List<Apontamento> apontamentos)
    {
        this.apontamentos = apontamentos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return apontamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return apontamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return apontamentos.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Apontamento apontamento = apontamentos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item_apontamento, parent, false);
        }

        TextView campoNomeProjeto = (TextView) view.findViewById(R.id.item_nomeProjeto);
        campoNomeProjeto.setText(apontamento.getIDprojeto().toString());

        TextView campoNomeProfissional = (TextView) view.findViewById(R.id.item_nomeProfissional);
        campoNomeProfissional.setText(apontamento.getIDprofissional().toString());

        TextView campoDescricao = (TextView) view.findViewById(R.id.item_descricao);
        campoDescricao.setText(apontamento.getDescricao());

        //TextView campoHoras = (TextView) view.findViewById(R.id.item_idade);

        return view;
    }
}
