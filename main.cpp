#include <curl/curl.h>
#include <iostream>
#include <string>
#include "json.hpp"

size_t WriteCallback(void* contents, size_t size, size_t nmemb, std::string* userp) {
    size_t totalSize = size * nmemb;
    userp->append((char*)contents, totalSize);
    return totalSize;
}


int main(){
    CURL* curl;
    CURLcode res;
    std::string data;
    curl = curl_easy_init();

    if(curl){
        curl_easy_setopt(curl , CURLOPT_URL , "https://jsonplaceholder.typicode.com/todos/1");
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, WriteCallback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, &data);
        res = curl_easy_perform(curl);

        cJSON::readJSON(data);
        
        curl_easy_cleanup(curl);
    }
}