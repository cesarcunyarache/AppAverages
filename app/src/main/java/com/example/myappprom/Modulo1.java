package com.example.myappprom;

import android.widget.Button;
import android.os.Bundle;
import java.text.DecimalFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Modulo1 extends Fragment {


    public Button btnModulo1;

    public static final String ARG_PARAM1 = "param1 iriieie";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Button button;


    public Modulo1() {
        // Required empty public constructor
    }

    public static Modulo1 newInstance(String param1, String param2) {
        Modulo1 fragment = new Modulo1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_module1, container, false);


        return view;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnModulo1 = view.findViewById(R.id.btnModulo3);


        btnModulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pa1 = ((EditText) view.findViewById(R.id.txtPa6)).getText().toString();
                String pa2 = ((EditText) view.findViewById(R.id.txtPa7)).getText().toString();
                String ep = ((EditText) view.findViewById(R.id.txtExamenParcialIII)).getText().toString();

                if (pa1.equalsIgnoreCase("")  || pa2.equalsIgnoreCase("") || ep.equalsIgnoreCase("")) {
                    Toast.makeText(requireContext(), "Uno o más campos vacios", Toast.LENGTH_SHORT).show();
                    return;
                }
                double result = calcularPromedioUnidad1(
                        Double.parseDouble(pa1),
                        Double.parseDouble(pa2),
                        Double.parseDouble(ep));

                DecimalFormat df = new DecimalFormat("#0.0");


                ((TextView) view.findViewById(R.id.vResultadoUnidad3)).setText("El promedio de la Unidad I es: " + String.valueOf(df.format(result)));

                // Toast.makeText(requireContext(), "El promedio del Unidad I es: " + String.valueOf(result), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putDouble("U1", result);
                getParentFragmentManager().setFragmentResult("U1", bundle);
            }
        });
    }


    private double calcularPromedioUnidad1(double p1, double p2, double ep) {
        return (p1 * 0.30) + (p2 * 0.40) + (ep * 0.30);
    }
}

