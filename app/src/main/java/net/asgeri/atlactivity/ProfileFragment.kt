package net.asgeri.atlactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import net.asgeri.atlactivity.databinding.FragmentProfileBinding
import www.sanju.motiontoast.MotionToast


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val args:ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user=args.user

        binding.imageView3.setImageResource(user.image)
        binding.textView2.text=user.name

        binding.button.setOnClickListener {
            binding.imageView3.visibility=View.VISIBLE
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}