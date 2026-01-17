package bot.data;

import bot.data.QuestionData;

import java.util.List;

public interface QuestionSource {
    public List<QuestionData> loadQuestions();
    
}
