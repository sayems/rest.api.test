using System;
using NUnit.Framework;
using RestSharp;
using RestSharpCore.model;

namespace RestSharpExample.test
{
    [TestFixture]
    public class CommentTest
    {
        [Test]
        public void CommentWhereIDEquals1()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("comments/1", Method.GET);
            request.AddUrlSegment("id", "1");

            var responseCommentModel = client.Execute<Comment>(request);

            Assert.AreEqual(1, responseCommentModel.Data.id,
                string.Format("ID {0} does not match actually {1}", 1, responseCommentModel.Data.id));
        }

        [Test]
        public void CommentWherePostIdEquals1()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("comments/1", Method.GET);
            request.AddUrlSegment("id", "1");

            IRestResponse<Comment> responseCommentModel = client.Execute<Comment>(request);

            Assert.AreEqual(1, responseCommentModel.Data.postId,
                string.Format("PostID {0} does not match actually {1}", 1, responseCommentModel.Data.postId));
        }


        [Test]
        public void CommentWhereBodyContainsIspam()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("comments/1", Method.GET);
            request.AddUrlSegment("id", "1");

            IRestResponse<Comment> responseCommentModel = client.Execute<Comment>(request);
            var assert = responseCommentModel.Data.body.Contains("ipsam");
            Assert.IsTrue(assert);
        }


        [Test]
        public void CommentEmailTest()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri("http://jsonplaceholder.typicode.com/");

            var request = new RestRequest("comments/1", Method.GET);
            request.AddUrlSegment("id", "1");

            IRestResponse<Comment> responseCommentModel = client.Execute<Comment>(request);

            Assert.AreEqual("Eliseo@gardner.biz", responseCommentModel.Data.email,
                string.Format("Email {0} does not match {1}", "Eliseo@gardner.biz", responseCommentModel.Data.body));
        }
    }
}