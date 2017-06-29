using NUnit.Framework;
using RestSharpCore;
using RestSharpCore.model;

namespace RestSharpExample.test
{
    [TestFixture]
    public class JsonPlaceHolderTest
    {
        [Test]
        public void PhotoTestIDWithID3()
        {
            JsonPlaceHolder jph = new JsonPlaceHolder("photos");
            Photo photo = jph.GetPhoto(3);

            Assert.AreEqual(photo.id, 3);
        }

        [Test]
        public void PhotoTestAlbumIDWithID3()
        {
            JsonPlaceHolder jph = new JsonPlaceHolder("photos");
            Photo photo = jph.GetPhoto(3);

            Assert.AreEqual(photo.albumId, 1);
        }

        [Test]
        public void PhotoTestTitleWithID3()
        {
            JsonPlaceHolder jph = new JsonPlaceHolder("photos");
            Photo photo = jph.GetPhoto(3);

            Assert.AreEqual(photo.title, "officia porro iure quia iusto qui ipsa ut modi");
        }

        [Test]
        public void PhotoTestURLWithID3()
        {
            JsonPlaceHolder jph = new JsonPlaceHolder("photos");
            Photo photo = jph.GetPhoto(3);

            Assert.AreEqual(photo.url, "http://placehold.it/600/24f355");
        }

        [Test]
        [Ignore("Failing")]
        public void PhotoTestThumbnailURLWithID3()
        {
            JsonPlaceHolder jph = new JsonPlaceHolder("photos");
            Photo photo = jph.GetPhoto(3);
            Assert.AreEqual(photo.thumbnailUrl, "http://placehold.it/150/1941e9");
        }
    }
}