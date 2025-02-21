import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chatnote.coredata.db.FolderDao
import com.chatnote.coredata.model.FolderEntity

import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(peopleDao: FolderDao) {
    MaterialTheme {
        val people by peopleDao.observeFoldersWithLastNote().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            val peopleList = listOf(
                FolderEntity(name = "User1", iconUri = "", createdAt = currentTimeMillis(), pinnedDate = 0),
                FolderEntity(name = "User2", iconUri = "", createdAt = currentTimeMillis(), pinnedDate = 0),
                FolderEntity(name = "User3", iconUri = "", createdAt = currentTimeMillis(), pinnedDate = 0),
                FolderEntity(name = "User4", iconUri = "", createdAt = currentTimeMillis(), pinnedDate = 0),

                )
            peopleList.forEach {
                peopleDao.insertOrReplaceFolder(it)
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(people) { person ->
                Text(
                    text = person.folder.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch {
                                peopleDao.deleteFolder(person.folder.id?:0)
                            }
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}