import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        // arrange
        val post1 = Post(id = WallService.getNewId(), text = "test post")
        val post2 = Post(id = WallService.getNewId(), text = "test post")
        val post3 = Post(id = WallService.getNewId(), text = "test post")

        // act
        val result1 = WallService.add(post1)
        val result2 = WallService.add(post2)
        val result3 = WallService.add(post3)

        // assert

        assert(post1 == result1)
        assert(post1.id != 0)

    }

    @Test
    fun update() {

        // arrange
        val post1 = Post(id = WallService.getNewId(), text = "test post1")
        val post2 = Post(id = WallService.getNewId(), text = "test post2")
        val post3 = Post(id = WallService.getNewId(), text = "test post3")

        val incorrectIdPost = Post(id = 999, text = "incorrect post")

        // act
        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val newText = "new text"
        val post4 = post2.copy(text = newText)
        val updateResult = WallService.update(post4)
        val incorrectPostResult = WallService.update(incorrectIdPost)

        val postForCompare = WallService.getById(post4.id)

        // assert
        assert(updateResult)
        assert(!incorrectPostResult)
        assert(post4.text == newText)
        if (postForCompare != null) {
            assert(post4.text == postForCompare.text)
        } else {
            assert(false)
        }

    }

    @Test
    fun getById() {

        // arrange
        val post1 = Post(id = WallService.getNewId(), text = "test post1")
        val post2 = Post(id = WallService.getNewId(), text = "test post2")
        val post3 = Post(id = WallService.getNewId(), text = "test post3")

        // act
        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val result = WallService.getById(post2.id)

        // assert
        if (result != null){
            assert(result.id == post2.id)
            assert(result == post2)
        } else {
            assert(false)
        }

    }

}

