import logo from './logo.svg';
import LoginRegister from './components/login-register/login_register';
import ProfileInfo from './components/login-register/profile_info';
import Homepage from './components/homepage/homepage';
import Post from './components/post/post';
import CommunityHome from './components/community_page/community_home'
import CreatePostType from './components/createposttype/create_post_type'
import ProfilePage from './components/profile/profile_page'
import AdvancedSearch from './components/search/advanced_search';

import {
    BrowserRouter,
    Routes,
    Route,
    useNavigate,
} from "react-router-dom";
import CreatePost from './components/createpost/create_post';
import Search from './components/search/search_page';

const asd = () => (<div>HELLOOOO</div>);

function App() {
    //let navigate = useNavigate();
    //const handleClick = () => {navigate("/invoices")}
  return (
      <div>
        <BrowserRouter>
          <Routes>
              <Route path="/" element={<LoginRegister />} />
              <Route path="/home" element={<Homepage />} />
              <Route path="/profile-info" element={<ProfileInfo />} />
              <Route path="/community-home/:community_name_" element={<CommunityHome />} />
              <Route path="/create-post-type" element={<CreatePostType />} />
              <Route path="/create-post" element={<CreatePost />} />
              <Route path="/post" element={<Post />} />
              <Route path ="/profile-page/:user_name_" element = {<ProfilePage />} />
              <Route path ="/search-page/:search_item" element = {<Search />} />
              <Route path ="/advanced-search/:community_id" element = {<AdvancedSearch />} />
          </Routes>
        </BrowserRouter> 
      </div>
  );
}

export default App;
