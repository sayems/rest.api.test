using System;
using System.Net;
using NUnit.Framework;
using RestSharp;

namespace RestSharpCore.test
{
    [TestFixture]
    public class StatusTest
    {
        [Test]
        public void ResponseReturnedComments200()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("comments");

            IRestResponse response = client.Execute(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode,
                string.Format("Status code {0} does not match actually {1}", HttpStatusCode.OK, response.StatusCode));
        }

        [Test]
        public void ResponseReturnedPosts200()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("posts");

            IRestResponse response = client.Execute(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode,
                string.Format("Status code {0} does not match actually {1}", HttpStatusCode.OK, response.StatusCode));
        }

        [Test]
        public void ResponseReturnedAlbums200()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("albums");

            IRestResponse response = client.Execute(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode,
                string.Format("Status code {0} does not match actually {1}", HttpStatusCode.OK, response.StatusCode));
        }

        [Test]
        public void ResponseReturnedPhotos200()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("photos");

            IRestResponse response = client.Execute(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode,
                string.Format("Status code {0} does not match actually {1}", HttpStatusCode.OK, response.StatusCode));
        }

        [Test]
        public void ResponseReturnedTodos200()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("todos");

            IRestResponse response = client.Execute(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode,
                string.Format("Status code {0} does not match actually {1}", HttpStatusCode.OK, response.StatusCode));
        }

        [Test]
        public void ResponseReturnedUsers200()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("users");

            IRestResponse response = client.Execute(request);

            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode,
                string.Format("Status code {0} does not match actually {1}", HttpStatusCode.OK, response.StatusCode));
        }
    }
}