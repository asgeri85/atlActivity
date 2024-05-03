package net.asgeri.atlactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        val users = arrayListOf<User>(
            User("ali", R.drawable.gul),
            User("fatih", R.drawable.agla), User("adadas", R.drawable.icon)
        )

        val nameAdapter = NameAdapter()

        nameAdapter.updateList(users)

        binding.rvHome.adapter = nameAdapter




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}