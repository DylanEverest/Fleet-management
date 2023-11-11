import axios from 'axios';

const ApiService = {

    baseURL: "https://default.com" ,
 
    get: async (url, customBaseURL) => {
    try 
    {
      const baseURL = customBaseURL || ApiService.baseURL;
      const response = await axios.get(`${baseURL}/${url}`);
      return response.data;
    } 
    catch (error) 
    {
      throw error;
    }
  },

  post: async (url, data, customBaseURL) => {
    try 
    {
      const baseURL = customBaseURL || ApiService.baseURL;
      const response = await axios.post(`${baseURL}/${url}`, data);
      return response.data;
    } 
    catch (error) 
    {
      throw error;
    }
  },

  put: async (url, data, customBaseURL) => {
    try 
    {
      const baseURL = customBaseURL || ApiService.baseURL;
      const response = await axios.put(`${baseURL}/${url}`, data);
      return response.data;
    } 
    catch (error) 
    {
      throw error;
    }
  },

  delete: async (url, customBaseURL) => 
  {
    try 
    {
      const baseURL = customBaseURL || ApiService.baseURL;
      const response = await axios.delete(`${baseURL}/${url}`);
      return response.data;
    } 
    catch (error) 
    {
      throw error;
    }
  },
};

export default ApiService;
