package net.asgeri.atlactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import net.asgeri.atlactivity.databinding.CustomDialogBinding
import net.asgeri.atlactivity.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
           createCustomDialog()
        }

    }

    private fun createDialog() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("Hata 404")
        dialog.setMessage("bir hata meydana geldi")
        dialog.setNegativeButton("Xeyir") { _, _ ->
            Toast.makeText(context, "Xeyiri basdiniz", Toast.LENGTH_SHORT).show()
        }

        dialog.setPositiveButton("Beli") { _, _ ->
            Toast.makeText(context, "Beliye basdiniz", Toast.LENGTH_SHORT).show()
        }

        dialog.create().show()
    }

    private fun createCustomDialog() {
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(requireContext()).create()

        dialog.setView(dialogBinding.root)

        dialog.show()

        dialogBinding.button3.setOnClickListener {
            dialog.dismiss()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}