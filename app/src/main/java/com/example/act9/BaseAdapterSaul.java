package com.example.act9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseAdapterSaul extends BaseAdapter {

    private Context context;
    private String[] Figuras;
    private int[] Imagenes;

    public BaseAdapterSaul(Context context, String[] nombresFiguras, int[] listaImagenes) {
        this.context = context;
        this.Figuras = nombresFiguras;
        this.Imagenes = listaImagenes;
    }

    @Override
    public int getCount() {
        return Figuras.length;
    }

    @Override
    public Object getItem(int position) {
        return Figuras[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.base, null);

            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.textViewPerimetro = convertView.findViewById(R.id.textViewPerimetro);
            holder.textViewArea = convertView.findViewById(R.id.textViewArea);
            holder.textViewVolumen = convertView.findViewById(R.id.textViewVolumen);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(Imagenes[position]);

        // Aquí establece las fórmulas según la figura correspondiente
        String formulaPerimetro = obtenerPerimetro(Figuras[position]);
        String formulaArea = obtenerArea(Figuras[position]);
        String formulaVolumen = obtenerVolumen(Figuras[position]);

        // Añadir la lógica para mostrar el volumen solo si la figura es cilindro o cubo
        if (Figuras[position].equalsIgnoreCase("Cilindro") || Figuras[position].equalsIgnoreCase("Cubo")) {
            holder.textViewPerimetro.setVisibility(View.GONE);
            holder.textViewArea.setVisibility(View.GONE);
            holder.textViewVolumen.setVisibility(View.VISIBLE);
            holder.textViewVolumen.setText("Volumen: " + formulaVolumen);
        } else {
            // Mostrar área y perímetro para otras figuras
            holder.textViewPerimetro.setVisibility(View.VISIBLE);
            holder.textViewArea.setVisibility(View.VISIBLE);
            holder.textViewVolumen.setVisibility(View.GONE);

            holder.textViewPerimetro.setText("Perímetro: " + formulaPerimetro);
            holder.textViewArea.setText("Área: " + formulaArea);
        }

        return convertView;
    }


    static class ViewHolder {
        ImageView imageView;
        TextView textViewPerimetro;
        TextView textViewArea;
        TextView textViewVolumen; // Agregado
    }

    // Método para obtener la fórmula del perímetro según la figura
    private String obtenerPerimetro(String figura) {
        switch (figura) {
            case "Triángulo Escaleno":
                return "A + B + C";
            case "y":
                return "i";
            case "Pentágono":
                return "L + L + L + L + L";
            case "u":
                return "u";
            default:
                return "";
        }
    }

    // Método para obtener la fórmula del área según la figura
    private String obtenerArea(String figura) {
        switch (figura) {
            case "Triángulo Escaleno":
                return "B * H / 2";
            case "p":
                return "B";
            case "Pentágono":
                return "(Perimetro * Apotema) / 2";
            case "u":
                return "e";
            default:
                return "";
        }
    }

    // Método para obtener la fórmula del volumen según la figura
    private String obtenerVolumen(String figura) {
        switch (figura) {
            case "cilindro":
                return "π * r^2 * h";
            case "cubo":
                return "a^3";
            default:
                return "";
        }
    }
}
