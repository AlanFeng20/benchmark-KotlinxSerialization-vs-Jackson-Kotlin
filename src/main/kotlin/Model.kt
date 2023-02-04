import kotlinx.serialization.Serializable

@Serializable
data class Model(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)