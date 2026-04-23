/*The program is the solution of codeforces problem no. 1999B
Regn no.: 2025CA085
Program Date: 22-04-2026
Program Time: 18:52 IST    */

/**
 *  ███████╗ █████╗ ███╗   ██╗██████╗ ██╗██████╗  █████╗ ███╗   ██╗
 *  ██╔════╝██╔══██╗████╗  ██║██╔══██╗██║██╔══██╗██╔══██╗████╗  ██║
 *  ███████╗███████║██╔██╗ ██║██║  ██║██║██████╔╝███████║██╔██╗ ██║
 *  ╚════██║██╔══██║██║╚██╗██║██║  ██║██║██╔═══╝ ██╔══██║██║╚██╗██║
 *  ███████║██║  ██║██║ ╚████║██████╔╝██║██║     ██║  ██║██║ ╚████║
 *  ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝ ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝
 *
 *                 S A N D I P A N   R A Y
 */

/*----------------------------------INCLUDES & NAMESPACE----------------------------------*/
#include <bits/stdc++.h>
using namespace std;

/*----------------------------------MACROS----------------------------------*/
#define sza(x) ((int)(x).size())
#define all(a) (a).begin(), (a).end()
#define rall(x) (x).rbegin(), (x).rend()
#define pb push_back
#define mp make_pair
#define f first
#define s second
#define gcd(a, b) __gcd(a, b)

/*----------------------------------TYPE ALIASES----------------------------------*/
using ll = long long;
using ld = long double;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using vi = vector<int>;
using vll = vector<ll>;
using vpii = vector<pii>;
using vpll = vector<pll>;
using vc = vector<char>;
using umii = unordered_map<int, int>;
using umci = unordered_map<char, int>;
using umsi = unordered_map<string, int>;
using si = set<int>;
using sc = set<char>;

/*----------------------------------CONSTANTS----------------------------------*/
const int MAX_N = 1e5 + 5;
const ll MOD = 1e9 + 7;
const ll INF = 1e18;
const ld EPS = 1e-9;

/*----------------------------------MATH FUNCTIONS----------------------------------*/
ll lcm(ll a, ll b) { return (a / gcd(a, b)) * b; }

ll mod_add(ll a, ll b, ll m = MOD) { return (a % m + b % m) % m; }
ll mod_sub(ll a, ll b, ll m = MOD) { return ((a % m - b % m) + m) % m; }
ll mod_mul(ll a, ll b, ll m = MOD) { return (a % m * b % m) % m; }

ll mod_exp(ll a, ll b, ll m = MOD) {
    ll res = 1;
    while (b > 0) {
        if (b & 1) res = mod_mul(res, a, m);
        a = mod_mul(a, a, m);
        b >>= 1;
    }
    return res;
}

/*----------------------------------BINARY EXPONENTIATION----------------------------------*/
ll binpow(ll b, ll n) {
    ll result = 1;
    while (n > 0) {
        if (n & 1) result *= b;
        b *= b;
        n >>= 1;
    }
    return result;
}

/*----------------------------------PRIME SIEVE FUNCTION----------------------------------*/
bool prime(ll a) {
    static const ll MAX = 1000005;
    static vector<bool> isPrime(MAX, true);
    static bool initialized = false;
    if (!initialized) {
        isPrime[0] = isPrime[1] = false;
        for (ll i = 2; i * i < MAX; ++i) {
            if (isPrime[i]) {
                for (ll j = i * i; j < MAX; j += i)
                    isPrime[j] = false;
            }
        }
        initialized = true;
    }
    if (a < 0 || a >= MAX) return false;
    return isPrime[a];
}

/*----------------------------------UTILITY OUTPUT FUNCTIONS----------------------------------*/
inline void yes() { cout << "YES\n"; }
inline void no()  { cout << "NO\n"; }

/*----------------------------------INPUT/OUTPUT HELPERS----------------------------------*/
template <typename T>
void read(vector<T>& v) { for (auto& x : v) cin >> x; }

template <typename T>
void print(const vector<T>& v) { for (const auto& x : v) cout << x << ' '; cout << '\n'; }

/*----------------------------------SOLVE FUNCTION----------------------------------*/
void solve() {
    int a, b, c, d; 
    cin >> a >> b >> c >> d;
    int winCount = 0;
    int s1 = 0, p1 = 0;
    if (a > c) s1++; else if (c > a) p1++;
    if (b > d) s1++; else if (d > b) p1++;
    if (s1 > p1) winCount++;
    int s2 = 0, p2 = 0;
    if (a > d) s2++; else if (d > a) p2++;
    if (b > c) s2++; else if (c > b) p2++;
    if (s2 > p2) winCount++;
    int s3 = 0, p3 = 0;
    if (b > c) s3++; else if (c > b) p3++;
    if (a > d) s3++; else if (d > a) p3++;
    if (s3 > p3) winCount++;
    int s4 = 0, p4 = 0;
    if (b > d) s4++; else if (d > b) p4++;
    if (a > c) s4++; else if (c > a) p4++;
    if (s4 > p4) winCount++;
    cout << winCount << endl;
}

/*----------------------------------MAIN FUNCTION----------------------------------*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}