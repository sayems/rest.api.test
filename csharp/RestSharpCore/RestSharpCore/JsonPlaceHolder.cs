using System;
using RestSharp;
using RestSharpCore.model;

namespace RestSharpCore
{
    public class JsonPlaceHolder
    {
        private const string BaseURL = "http://jsonplaceholder.typicode.com/";

        private readonly string _endPoint;

        public JsonPlaceHolder(string endPoint)
        {
            _endPoint = endPoint;
        }

        public static T Execute<T>(RestRequest request) where T : new()
        {
            var client = new RestClient();
            client.BaseUrl = new Uri(BaseURL);

            var response = client.Execute<T>(request);

            if (response.ErrorException != null)
                throw new Exception();

            return response.Data;
        }

        public Photo GetPhoto(int id)
        {
            var request = new RestRequest();
            request.Resource = "photos/{ID}"; //+ id.ToString();

            request.RootElement = "photos";

            request.AddParameter("ID", id.ToString(), ParameterType.UrlSegment);

            // JSONPlaceholder jph = new JSONPlaceholder("photos");
            return Execute<Photo>(request);
        }
    }
}