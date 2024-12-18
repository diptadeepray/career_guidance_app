package com.example.careerguidanceapp



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.careerguidanceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val interests = binding.interestsInput.text.toString()
            val skills = binding.skillsInput.text.toString()
            val educationLevel = binding.educationSpinner.selectedItem.toString()

            val careerSuggestion = getCareerSuggestion(interests, skills, educationLevel)
            binding.careerText.text = careerSuggestion
        }
    }

    private fun getCareerSuggestion(interests: String, skills: String, educationLevel: String): String {
        if (interests.isBlank() || skills.isBlank()) {
            return "Please provide your interests and skills."
        }

        return when {
            educationLevel == "High School" && interests.contains("technology", ignoreCase = true) -> "Consider careers in IT support or software testing."
            educationLevel == "Undergraduate" && skills.contains("programming", ignoreCase = true) -> "Explore roles like Software Developer or Data Analyst."
            interests.contains("creativity", ignoreCase = true) -> "Graphic Design or Content Creation might be great for you."
            skills.contains("management", ignoreCase = true) -> "Look into Project Management or HR roles."
            else -> "Research fields that align with your unique combination of skills and interests."
        }
    }
}
