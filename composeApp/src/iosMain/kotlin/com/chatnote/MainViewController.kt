import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.chatnote.coredata.db.getAppDatabase

fun MainViewController() = ComposeUIViewController {
    val dao = remember {
        getAppDatabase().folderDao()
    }
    App(dao)
}