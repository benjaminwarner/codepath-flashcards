package boisestate.warner.benjamin.flashcards;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Flashcard.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FlashcardDao flashcardDao();
}
