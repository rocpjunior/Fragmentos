package com.example.fragmentos

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [card.newInstance] factory method to
 * create an instance of this fragment.
 */
class Termo : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val builder = AlertDialog.Builder(requireContext())
            val inflacionador = LayoutInflater.from(requireContext())
            val view = inflacionador.inflate(R.layout.fragment_termo, null)
            val McCbo = view.findViewById<CheckBox>(R.id.cboAceito)
            val ok = view.findViewById<Button>(R.id.btnAceitar) //Resgata o botão Aceitar
            val cancelar = view.findViewById<Button>(R.id.btnCancelar)

        McCbo.setOnClickListener{
                    if (McCbo.isChecked){ //Verifica se esta aceito ou não os termos de uso no checkbox
                ok.isEnabled = true //Habilita o botão
            } else {
                ok.isEnabled = false //Desabilita o botão
            }
                }

            ok.setOnClickListener {
                dismiss() //Fecha o diálogo
                //Toast.makeText(this, "Bem-Vindo a tela Inicial", Toast.LENGTH_SHORT).show()
            }

            cancelar.setOnClickListener {
                requireActivity().finish() //Obtém a herança da atividade
            }

        builder.setView(view) //Coloca o elemento dentro do construtor, e acaba criando ele =D
        return builder.create() //Retorna a criação desse elemento
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment card.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Termo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}