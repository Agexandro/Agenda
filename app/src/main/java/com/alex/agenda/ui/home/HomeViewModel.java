package com.alex.agenda.ui.home;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.alex.agenda.ui.database.DAOAgenda;
import com.alex.agenda.ui.database.Notes;
import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    ArrayList paqueteDatos(Context context) {
        DAOAgenda lista = new DAOAgenda(context);
        return lista.getAll();
    }
}