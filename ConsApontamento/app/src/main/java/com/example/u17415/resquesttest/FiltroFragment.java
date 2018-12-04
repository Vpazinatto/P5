package com.example.u17415.resquesttest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

public class FiltroFragment extends DialogFragment {
    String[] projetos = {"a", "b", "c", "d", "e"};
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        int checkedItem = 1;
        builder.setView(inflater.inflate(R.layout.filtro_dialog, null))
                .setTitle(R.string.filtro)
                .setSingleChoiceItems(projetos, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0: {

                            }
                            case 1: {

                            }
                            case 2: {

                            }
                            case 3: {

                            }
                            case 4: {

                            }
                            case 5: {

                            }
                        }
                    }
                })
                .setPositiveButton(R.string.apply, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
